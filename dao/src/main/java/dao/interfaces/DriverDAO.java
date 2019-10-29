package dao.interfaces;

import entity.BaseEntity;
import entity.Bus;
import entity.Driver;

public interface DriverDAO<T extends BaseEntity> extends UserDAO {
    void associateWithBus(Driver driver, Bus bus);

    void sendReport(String str);

    void replyToFeedback(T t);
}
