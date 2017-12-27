package com.xuhong.xmqtt_master.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * 项目名： xMQTT-master
 * 包名名： com.xuhong.xmqtt_master.db
 * 创建者: xuhong  GitHub-> https://github.com/xuhongv
 * 创建时间: 2017/12/25.
 * 描述：TOMO
 */

@Entity
public class PublishMessage {

    //id
    @Id
    private Long key;

    //发布的主题
    private String topic;

    //发送的消息
    private String message;


    @ToOne(joinProperty = "publishId")
    private DBClient dbClient;

    private Long publishId;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 945288082)
    private transient PublishMessageDao myDao;

    @Generated(hash = 503696575)
    public PublishMessage(Long key, String topic, String message, Long publishId) {
        this.key = key;
        this.topic = topic;
        this.message = message;
        this.publishId = publishId;
    }

    @Generated(hash = 981586076)
    public PublishMessage() {
    }

    public Long getKey() {
        return this.key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getPublishId() {
        return this.publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    @Generated(hash = 851890534)
    private transient Long dbClient__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1830692157)
    public DBClient getDbClient() {
        Long __key = this.publishId;
        if (dbClient__resolvedKey == null || !dbClient__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DBClientDao targetDao = daoSession.getDBClientDao();
            DBClient dbClientNew = targetDao.load(__key);
            synchronized (this) {
                dbClient = dbClientNew;
                dbClient__resolvedKey = __key;
            }
        }
        return dbClient;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 916902848)
    public void setDbClient(DBClient dbClient) {
        synchronized (this) {
            this.dbClient = dbClient;
            publishId = dbClient == null ? null : dbClient.getKey();
            dbClient__resolvedKey = publishId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 366219332)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPublishMessageDao() : null;
    }

}
