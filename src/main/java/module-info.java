module com.fxtetris.fxtetris {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires JavaFx2DEngine;
    requires UnityMath;

    opens com.fxtetris to javafx.fxml;
    exports com.fxtetris;
}