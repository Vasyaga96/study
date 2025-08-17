package org.example.patterns.visitor;

public interface ComputerVisitor {
    void visitMotherboard(Motherboard motherboard);
    void visitCPU(CPU cpu);
    void visitRAM(RAM ram);
    void visitDisk(Disk disk);
    void visitGraphicsCard(GraphicsCard graphicsCard);
}
