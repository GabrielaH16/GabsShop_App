package sv.edu.catolica.gabsshopapp.models;

public class CategoryModel {
    String url_img;
    String name;
    String type;

    public CategoryModel() {
    }

    public CategoryModel(String url_img, String name, String type) {
        this.url_img = url_img;
        this.name = name;
        this.type = type;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
