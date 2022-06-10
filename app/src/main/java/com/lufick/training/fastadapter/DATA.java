package com.lufick.training.fastadapter;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;

public enum DATA {
    NEERAJ(GoogleMaterial.Icon.gmd_adjust, "Neeraj", "Good boy"),
    TARUN(GoogleMaterial.Icon.gmd_3d_rotation, "Tarun", "Intelligent boy"),
    SHUBHAM(GoogleMaterial.Icon.gmd_ac_unit, "Shubham", "Good boy in this"),
    ABAC(GoogleMaterial.Icon.gmd_add, "Abac", "Good boy is not good"),
    CAR(GoogleMaterial.Icon.gmd_access_alarm, "Car", "Good vehicle"),
    BUS(GoogleMaterial.Icon.gmd_account_balance_wallet, "Bus", "Very croweded"),
    CYCLE(GoogleMaterial.Icon.gmd_accessibility, "Cycle", "Good for exercise"),
    MEDICINE(GoogleMaterial.Icon.gmd_add_box, "Medicine", "Bad for health"),
    MILK(GoogleMaterial.Icon.gmd_zoom_in, "Milk", "Good for daily use"),
    RAJ(GoogleMaterial.Icon.gmd_tag_faces, "Raj", "Good person"),
    SIX(GoogleMaterial.Icon.gmd_zoom_out_map, "Six", "A mathematicle number"),
    RAHUL(GoogleMaterial.Icon.gmd_youtube_searched_for, "Rahul", "Bad person boy"),
    BIKE(GoogleMaterial.Icon.gmd_whatshot, "Bike", "Bad for youngster"),
    DUPLICATE_NEERAJ(GoogleMaterial.Icon.gmd_near_me, "Neeraj", "Good boy")
    ;
    String title, subtitle;
    IIcon iconName;

    DATA(IIcon iconName, String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
        this.iconName = iconName;
    }
}
