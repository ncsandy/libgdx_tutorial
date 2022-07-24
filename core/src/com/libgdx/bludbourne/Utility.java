package com.libgdx.bludbourne;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public final class Utility {

    public static final AssetManager _assetManager =
            new AssetManager();

    private static final String TAG = Utility.class.getSimpleName();

    private static InternalFileHandleResolver _filePathResolver =
            new InternalFileHandleResolver();

    public static void unLoadAsset(String assetFilenamePath) {
        // once the asset manager is done loading
        if (_assetManager.isLoaded(assetFilenamePath)) {
            _assetManager.unload(assetFilenamePath);
        } else {
            Gdx.app.debug(TAG, "Asset is not loaded; Nothing to unload:" + assetFilenamePath);
        }
    }

    public static float loadCompleted() {
        return _assetManager.getProgress();
    }

    public static int numberAssetQueued(){
        return _assetManager.getQueuedAssets();
    }

    public static boolean updateAssetLoading(){
        return _assetManager.update();
    }

    public static boolean isAssetLoaded(String fileName){
        return _assetManager.isLoaded(fileName);
    }

    public static void loadMapAsset(String mapFilenamePath){
        if (mapFilenamePath == null || mapFilenamePath.isEmpty()) {
        return;
        }

        //load asset
        if (_filePathResolver.resolve(mapFilenamePath).exists()) {
            _assetManager.setLoader(
                    TiledMap.class, new TmxMapLoader(_filePathResolver));

            _assetManager.load(mapFilenamePath, TiledMap.class);

            //Until we add loading screen
            //just block until we load the map

            _assetManager.finishLoadingAsset(mapFilenamePath);
            Gdx.app.debug(TAG, "Map loaded!: " + mapFilenamePath);

        }
        else
        {
            Gdx.app.debug(TAG, "Map doesn't exist!: " + mapFilenamePath);
        }
    }

    public static TiledMap getMapAsset(String mapFilenamePath) {
        TiledMap map = null;

        //once asset manager is done loading
        if (_assetManager.isLoaded(mapFilenamePath)) {
            map = _assetManager.get(mapFilenamePath,TiledMap.class);
        }
        else
        {
            Gdx.app.debug(TAG, "Map is not loaded: " + mapFilenamePath);
        }
        return map;
    }
}

