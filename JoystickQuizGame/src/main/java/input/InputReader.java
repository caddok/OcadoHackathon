package input;

import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataEventListener;
import com.pi4j.io.serial.SerialFactory;
import com.pi4j.util.Console;

public class InputReader {
    public static void main(String[] args) {
        final Console console = new Console();
        console.title("The best quiz game");
        console.promptForExit();

        final Serial serial = SerialFactory.createInstance();

        serial.addListener(new SerialDataEventListener() {
            public void dataReceived(SerialDataEvent serialDataEvent) {

            }
        });
    }
}
