module org.example.magic_trick_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.magic_trick_fx to javafx.fxml;
    exports org.example.magic_trick_fx;
}