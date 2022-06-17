package Constant;

public enum Lever {
    GIAOSU_TIENSI("GS-TS"),
    PHOGIAOSU_TIENSI("PGS-TS"),
    GIANG_VIEN_CHINH("Giảng viên chính"),
    THAC_SY("Thạc sỹ");

    public String value;

    Lever(String value) {
        this.value = value;
    }
}
