package com.app2u.app2udemo.commons.data.local;

import com.app2u.app2udemo.features.artistlist.data.model.local.DataModalPhotographer;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {

    public static void addDataToDatabase(List<DataModalPhotographer> dataModalPhotographers) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.deleteAll();
                realm.copyToRealm(dataModalPhotographers);
            }
        });
    }


    public static RealmResults<DataModalPhotographer> getAllPhotographers() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(DataModalPhotographer.class)
                .findAll();
    }

}