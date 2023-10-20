package com.hao.library.ddd.repository.support;

import com.hao.library.ddd.common.Aggregate;
import com.hao.library.ddd.common.Identifier;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SnapshotUtils {

    @SuppressWarnings("unchecked")
    public static <T extends Aggregate<ID>, ID extends Identifier> T snapshot(T aggregate) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(aggregate);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            T snapshot = (T) objectInputStream.readObject();

            objectOutputStream.close();
            byteArrayOutputStream.close();

            objectInputStream.close();
            byteArrayInputStream.close();
            return snapshot;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}