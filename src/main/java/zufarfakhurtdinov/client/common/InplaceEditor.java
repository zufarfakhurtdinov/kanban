package zufarfakhurtdinov.client.common;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.*;
import jetbrains.jetpad.base.Registration;
import jetbrains.jetpad.model.event.EventHandler;
import jetbrains.jetpad.model.event.ListenerCaller;
import jetbrains.jetpad.model.event.Listeners;
import jetbrains.jetpad.model.property.Property;
import jetbrains.jetpad.model.property.PropertyChangeEvent;

import java.util.Objects;

/**
 * Created by dr on 13.04.2014.
 */
public class InplaceEditor {

    public static <T extends Widget & HasText, U extends Widget & HasText & Focusable> Property<String> editableTextOf(
            final T label, final ComplexPanel panelToHide, final U editorWidget) {
        return new Property<String>() {
            private String myValue;
            private boolean myEditing;
            private Listeners<EventHandler<? super PropertyChangeEvent<String>>> myListeners = new Listeners<>();

            {
                label.addDomHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        startEditing();
                    }
                }, ClickEvent.getType());
                editorWidget.addDomHandler(new KeyDownHandler() {
                    @Override
                    public void onKeyDown(KeyDownEvent event) {
                        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                            set(editorWidget.getText());
                            stopEditing();
                            return;
                        }

                        if (event.getNativeKeyCode() == KeyCodes.KEY_ESCAPE) {
                            stopEditing();
                            return;
                        }
                    }
                }, KeyDownEvent.getType());
                editorWidget.addDomHandler(new BlurHandler() {
                    @Override
                    public void onBlur(BlurEvent event) {
                        if (myEditing) {
                            stopEditing();
                        }
                    }
                }, BlurEvent.getType());
            }

            private void startEditing() {
                if (myEditing) {
                    throw new IllegalStateException();
                }
                myEditing = true;

                panelToHide.setVisible(false);
                editorWidget.setVisible(true);
                editorWidget.setText(myValue);
                editorWidget.setFocus(true);
            }

            private void stopEditing() {
                if (!myEditing) {
                    throw new IllegalStateException();
                }
                myEditing = false;
                label.setText(myValue);

                panelToHide.setVisible(true);
                editorWidget.setVisible(false);
            }

            @Override
            public String get() {
                return myValue;
            }

            @Override
            public void set(String value) {
                if (Objects.equals(myValue, value)) {
                    return;
                }

                String oldValue = myValue;
                myValue = value;
                if (myEditing) {
                    editorWidget.setText(value);
                } else {
                    label.setText(value);
                }

                final PropertyChangeEvent<String> event = new PropertyChangeEvent<>(oldValue, value);
                myListeners.fire(new ListenerCaller<EventHandler<? super PropertyChangeEvent<String>>>() {
                    @Override
                    public void call(EventHandler<? super PropertyChangeEvent<String>> l) {
                        l.onEvent(event);
                    }
                });
            }

            @Override
            public Registration addHandler(EventHandler<? super PropertyChangeEvent<String>> handler) {
                return myListeners.add(handler);
            }

            @Override
            public String getPropExpr() {
                return "editableTextOf(" + label + ")";
            }
        };
    }
}