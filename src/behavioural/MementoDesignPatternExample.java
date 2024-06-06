package behavioural;

import java.util.ArrayList;
import java.util.List;

// Originator class whose state needs to be saved
class Editor {
    private String content;

    public Editor() {
        this.content = "";
    }

    public void type(String words) {
        this.content += words;
    }

    public String getContent() {
        return this.content;
    }

    // Save the current state of the editor
    public EditorMemento save() {
        return new EditorMemento(this.content);
    }

    // Restore the state of the editor
    public void restore(EditorMemento memento) {
        this.content = memento.getContent();
    }
}

// Memento class to store the state of the Editor
class EditorMemento {
    private final String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}

// Caretaker class responsible for managing the mementos
class History {
    private final List<EditorMemento> mementos = new ArrayList<>();

    public void addMemento(EditorMemento memento) {
        mementos.add(memento);
    }

    public EditorMemento getMemento(int index) {
        return mementos.get(index);
    }
}

public class MementoDesignPatternExample {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        // Type some content and save the state
        editor.type("This is the first sentence. ");
        history.addMemento(editor.save());

        // Type some more content and save the state
        editor.type("This is the second sentence. ");
        history.addMemento(editor.save());

        // Type even more content
        editor.type("This is the third sentence. ");

        // Restore to the previous state
        editor.restore(history.getMemento(1));

        System.out.println(editor.getContent()); // Output: This is the first sentence. This is the second sentence.
    }
}
