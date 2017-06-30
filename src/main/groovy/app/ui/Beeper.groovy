package app.ui
import com.vaadin.annotations.JavaScript
import com.vaadin.ui.AbstractJavaScriptComponent

@JavaScript("js/beeper_connector.js")
class Beeper extends AbstractJavaScriptComponent {

    void beep(Integer duration, Integer frequency) {
        callFunction('beep', duration, frequency)
    }

}
