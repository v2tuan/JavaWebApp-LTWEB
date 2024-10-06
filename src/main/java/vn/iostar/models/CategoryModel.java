package vn.iostar.models;

import java.io.Serializable;

public class CategoryModel implements Serializable {

    private int categoryId;
    private String categoryName;
    private String image;
    private int status;

    public CategoryModel() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", image='" + image + '\'' +
                ", status=" + status +
                '}';
    }
}
