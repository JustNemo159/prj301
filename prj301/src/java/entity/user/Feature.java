/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.user;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Feature {
    private int FeatureID;
    private String FeatureName;
    private String url;

    public Feature() {
    }

    public Feature(int featureID, String featureName, String url) {
        this.FeatureID = featureID;
        this.FeatureName = featureName;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "FeatureID=" + FeatureID +
                ", FeatureName='" + FeatureName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public int getFeatureID() {
        return FeatureID;
    }

    public void setFeatureID(int featureID) {
        FeatureID = featureID;
    }

    public String getFeatureName() {
        return FeatureName;
    }

    public void setFeatureName(String featureName) {
        FeatureName = featureName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}