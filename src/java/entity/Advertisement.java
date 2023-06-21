
package entity;

import java.util.Date;

public class Advertisement {
    private String id;
    private String ownerEmail;
    private String type;
    private int price;
    private String linkTo;
    private String linkShow;
    private Date dayStart;
    private Date dayEnd;

    public Advertisement() {
    }

    public Advertisement(String id, String ownerEmail, String type, int price, String linkTo, String linkShow, Date dayStart, Date dayEnd) {
        this.id = id;
        this.ownerEmail = ownerEmail;
        this.type = type;
        this.price = price;
        this.linkTo = linkTo;
        this.linkShow = linkShow;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLinkTo() {
        return linkTo;
    }

    public void setLinkTo(String linkTo) {
        this.linkTo = linkTo;
    }

    public String getLinkShow() {
        return linkShow;
    }

    public void setLinkShow(String linkShow) {
        this.linkShow = linkShow;
    }

    public Date getDayStart() {
        return dayStart;
    }

    public void setDayStart(Date dayStart) {
        this.dayStart = dayStart;
    }

    public Date getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(Date dayEnd) {
        this.dayEnd = dayEnd;
    }

    @Override
    public String toString() {
        return "Advertisement{" + "id=" + id + ", ownerEmail=" + ownerEmail + ", type=" + type + ", price=" + price + ", linkTo=" + linkTo + ", linkShow=" + linkShow + ", dayStart=" + dayStart + ", dayEnd=" + dayEnd + '}';
    }
    
    
}
