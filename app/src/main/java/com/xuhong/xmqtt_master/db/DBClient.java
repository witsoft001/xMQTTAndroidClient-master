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
public class DBClient {

    @Id
    private Long key;

    //登录名字
    private String Name;

    //登录密码
    private String password;

    //服务器地址
    private String address;

    //串口号
    private int port;



    //对接具体人的外键
    @ToMany(referencedJoinProperty = "publishId")
    private List<PublishMessage> userList;
    private Long publishId;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1709728317)
    private transient DBClientDao myDao;
    @Generated(hash = 73386235)
    public DBClient(Long key, String Name, String password, String address,
            int port, Long publishId) {
        this.key = key;
        this.Name = Name;
        this.password = password;
        this.address = address;
        this.port = port;
        this.publishId = publishId;
    }
    @Generated(hash = 293425734)
    public DBClient() {
    }
    public Long getKey() {
        return this.key;
    }
    public void setKey(Long key) {
        this.key = key;
    }
    public String getName() {
        return this.Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getPort() {
        return this.port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public Long getPublishId() {
        return this.publishId;
    }
    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 480913405)
    public List<PublishMessage> getUserList() {
        if (userList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PublishMessageDao targetDao = daoSession.getPublishMessageDao();
            List<PublishMessage> userListNew = targetDao
                    ._queryDBClient_UserList(key);
            synchronized (this) {
                if (userList == null) {
                    userList = userListNew;
                }
            }
        }
        return userList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1517531020)
    public synchronized void resetUserList() {
        userList = null;
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
    @Generated(hash = 53598485)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDBClientDao() : null;
    }




}
