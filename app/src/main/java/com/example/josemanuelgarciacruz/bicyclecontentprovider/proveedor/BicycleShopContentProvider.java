package com.example.josemanuelgarciacruz.bicyclecontentprovider.proveedor;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.SparseArray;

import com.example.josemanuelgarciacruz.bicyclecontentprovider.BicycleShopApplication;
import com.example.josemanuelgarciacruz.bicyclecontentprovider.bicycle.BicycleContract;
import com.example.josemanuelgarciacruz.bicyclecontentprovider.database.BicycleShopDatabase;

public class BicycleShopContentProvider extends ContentProvider {

    private final static int BICYCLE_ONE_REG = 1; //"content://com.example.josemanuelgarciacruz.bicyclecontentprovider.provider.BycycleShopContentPrivieder/Bicycle/#
    private final static int BICICLE_ALL_REGS = 2;//"content://com.example.josemanuelgarciacruz.bicyclecontentprovider.provider.BycycleShopContentPrivieder/Bicycle

    private static UriMatcher uriMatcher;
    private static SparseArray<String> mimeTypes;

    static {
        uriMatcher = new UriMatcher(0);
        mimeTypes = new SparseArray<>();

        uriMatcher.addURI(BicycleShopApplication.AUTORITY,
                BicycleContract.TABLE_NAME,
                BICICLE_ALL_REGS);
        uriMatcher.addURI(BicycleShopApplication.AUTORITY,
                BicycleContract.TABLE_NAME + "/#",
                BICYCLE_ONE_REG);

        mimeTypes.put(BICICLE_ALL_REGS,
                "vnd.android.cursor.dir/vnd:. " + BicycleContract.CONTENT_URI + "." + BicycleContract.TABLE_NAME);
        mimeTypes.put(BICYCLE_ONE_REG,
                "vnd.android.cursor.item/vnd:. " + BicycleContract.CONTENT_URI + "." + BicycleContract.TABLE_NAME);
    }

    BicycleShopDatabase deHelper;

    public BicycleShopContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        return mimeTypes.get(uriMatcher.match(uri));
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        deHelper = new BicycleShopDatabase(getContext());
        return deHelper == null ?  false: true;
    }

    @Override
    /*
    EN UN SELECT EN  SQL
    projection serian los campos
    selection seria la seleccion
    selectionArg argumentos de la seleccion
    sortOrder seri el equivalente a orderBy
     */
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        SQLiteDatabase db = deHelper.getReadableDatabase();

        switch (uriMatcher.match(uri)){

            case BICICLE_ALL_REGS:
                qb.setTables(BicycleContract.TABLE_NAME);
                break;
            case BICYCLE_ONE_REG:
                qb.setTables(BicycleContract.TABLE_NAME);
                break;
        }

        Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);

        return c;

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
