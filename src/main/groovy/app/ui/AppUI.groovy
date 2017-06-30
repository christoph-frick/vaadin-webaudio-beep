package app.ui

import com.vaadin.annotations.Theme
import com.vaadin.annotations.Widgetset
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Button
import com.vaadin.ui.Slider
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout

@SpringUI
@Theme('app')
@Widgetset('app')
class AppUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final beeper = new Beeper()
        final frequencyField = new Slider(20,20000).with{
            caption = "Frequency"
            value = 440d
            it
        }
        final durationField = new Slider(10,1000).with{
            caption = "Duration"
            value = 100d
            it
        }
        setContent(
                new VerticalLayout(
                        frequencyField,
                        durationField,
                        new Button("Make some noise").with {
                            addClickListener {
                                beeper.beep(durationField.value as Integer, frequencyField.value as Integer);
                            }
                            it
                        },
                        beeper
                )
        )
    }

}
