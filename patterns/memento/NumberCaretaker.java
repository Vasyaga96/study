package org.example.patterns.memento;

import java.util.ArrayList;
import java.util.List;

public class NumberCaretaker {
    private final List<NumberMemento> snapshots = new ArrayList<>();

    public int addSnapshot(NumberMemento snapshot) {
        snapshots.add(snapshot);
        return snapshots.size() - 1;
    }

    public NumberMemento getSnapshot(int index) {
        return snapshots.get(index);
    }

//    public List<SnapshotMetadata> getSnapshots() {
//        List<SnapshotMetadata> result = new ArrayList<>();
//
//        for (NumberMemento snapshot : snapshots) {
//            // преобразовать snapshot в SnapshotMetadata
//            // добавить SnapshotMetadata в массив result
//        }
//
//        return result;
//    }
}
