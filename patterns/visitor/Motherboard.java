package org.example.patterns.visitor;

import java.util.ArrayList;
import java.util.List;

public class Motherboard {
    private final CPU cpu = new CPU();
    private final List<RAM> ram = new ArrayList<>();
    private final List<Disk> disks = new ArrayList<>();
    private final GraphicsCard graphicsCard = new GraphicsCard();

    public Motherboard() {
        ram.add(new RAM(8));
        ram.add(new RAM(8));
        disks.add(new Disk(1024));
    }

    public void accept(ComputerVisitor visitor) {
        visitor.visitMotherboard(this);
        visitor.visitCPU(cpu);
        for (RAM ram : ram) {
            visitor.visitRAM(ram);
        }
        for (Disk disk : disks) {
            visitor.visitDisk(disk);
        }
        visitor.visitGraphicsCard(graphicsCard);
    }

    public void addRAM(int amount) {
        ram.add(new RAM(amount));
    }

    public int cost() {
        return 5000;
    }

    public int power() {
        return 10;
    }
}
