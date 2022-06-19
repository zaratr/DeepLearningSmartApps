package com.abdul_Codefellowship.codefellowship.nytimes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class News {
public Integer num_results;
public List<Result> results;




public class Result{
    public String updated_date;
    public String created_date;
    public String published_date;
    public List<Multimedium> multimedia = new ArrayList<Multimedium>();
    public String short_url;
    public String title;
//    public String abstract;
    @SerializedName("abstract")
    public String abst;

    public String url;

    public String getUpdated_date() {
        return updated_date;
    }

    public String getCreated_date() {
        return created_date;
    }

    public String getPublished_date() {
        return published_date;
    }

    public List<Multimedium> getMultimedia() {
        return multimedia;
    }

    public String getPictureSmall(){
        return multimedia.get(multimedia.size() -1).getUrl();
    }
    public String getPictureMedium(){
        if(multimedia == null) {
            return "nothing here to see" ;
        }
        return multimedia.get(multimedia.size() -2).getUrl();
    }

    public String getShort_url() {
        return short_url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Result{" +
                "updated_date='" + updated_date + '\'' +
                ", created_date='" + created_date + '\'' +
                ", published_date='" + published_date + '\'' +
                ", multimedia=" + multimedia +
                ", short_url='" + short_url + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
    public class Multimedium{

            public String url;
            public String format;
            public Integer height;
            public Integer width;
            public String type;
            public String subtype;
            public String caption;
            public String copyright;

        public String getUrl() {
            return url;
        }

        public String getFormat() {
            return format;
        }

        public Integer getHeight() {
            return height;
        }

        public Integer getWidth() {
            return width;
        }

        public String getType() {
            return type;
        }

        public String getSubtype() {
            return subtype;
        }

        public String getCaption() {
            return caption;
        }

        public String getCopyright() {
            return copyright;
        }

        @Override
        public String toString() {
            return "Multimedium{" +
                    "url='" + url + '\'' +
                    ", format='" + format + '\'' +
                    ", height=" + height +
                    ", width=" + width +
                    ", type='" + type + '\'' +
                    ", subtype='" + subtype + '\'' +
                    ", caption='" + caption + '\'' +
                    ", copyright='" + copyright + '\'' +
                    '}';
        }
    }

    public Integer getNum_results() {
        return num_results;
    }

    public void setNum_results(Integer num_results) {
        this.num_results = num_results;
    }

    public List<Result> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "News{" +
                "num_results=" + num_results +
                ", results=" + results +
                '}';
    }
}
