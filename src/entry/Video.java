package entry;


import java.sql.Timestamp;

public class Video {
    private int id;
    private String title;
    private String path;
    private Timestamp uploadtime;
    private String coverimg;
    private int uid;
    private int status;
    private int favcount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Timestamp uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getCoverimg() {
        return coverimg;
    }

    public void setCoverimg(String coverimg) {
        this.coverimg = coverimg;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFavcount() {
        return favcount;
    }

    public void setFavcount(int favcount) {
        this.favcount = favcount;
    }
}
