package javafx.admin.java.modules;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ManagedUsers {

    private StringProperty username;
    private StringProperty lastQRCode;
    private StringProperty lastQuestionAnswered;
    private StringProperty points;
    private StringProperty profilePicLink;

    public ManagedUsers(){}

    public ManagedUsers(String username, String lastQRCode, String lastQuestionAnswered, String points, String profilePicLink){
        this.username = new SimpleStringProperty(username);
        this.lastQRCode = new SimpleStringProperty(lastQRCode);
        this.lastQuestionAnswered = new SimpleStringProperty(lastQuestionAnswered);
        this.points = new SimpleStringProperty(points);
        this.profilePicLink = new SimpleStringProperty(profilePicLink);
    }

    /** GETTER **/
    public String getUsername() {
        return username.get();
    }

    public String getLastQRCode() {
        return lastQRCode.get();
    }

    public String getLastQuestionAnswered() {
        return lastQuestionAnswered.get();
    }

    public String getPoints() {
        return points.get();
    }

    public String getProfilePicLink() {
        return profilePicLink.get();
    }

    /** SETTER **/

    public void setUsername(String username) {
        this.username.set(username);
    }

    public void setLastQRCode(String lastQRCode) {
        this.lastQRCode.set(lastQRCode);
    }

    public void setLastQuestionAnswered(String lastQuestionAnswered) {
        this.lastQuestionAnswered.set(lastQuestionAnswered);
    }

    public void setPoints(String points) {
        this.points.set(points);
    }

    public void setProfilePicLink(String profilePicLink) {
        this.profilePicLink.set(profilePicLink);
    }

    /** PROPERTIES **/

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty lastQRCodeProperty() {
        return lastQRCode;
    }

    public StringProperty lastQuestionAnsweredProperty() {
        return lastQuestionAnswered;
    }

    public StringProperty pointsProperty() {
        return points;
    }

    public StringProperty profilePicLinkProperty() {
        return profilePicLink;
    }
}
