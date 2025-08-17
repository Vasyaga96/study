package org.example.patterns.visitor;

public class ComputerPowerVisitor implements ComputerVisitor {
    private int power = 0;

    public int getPower() {
        return power;
    }

    @Override
    public void visitMotherboard(Motherboard motherboard) {
        power += motherboard.power();
    }

    @Override
    public void visitCPU(CPU cpu) {
        power = cpu.power();
    }

    @Override
    public void visitRAM(RAM ram) {
        power = ram.power();
    }

    @Override
    public void visitDisk(Disk disk) {
        power = disk.power();
    }

    @Override
    public void visitGraphicsCard(GraphicsCard graphicsCard) {
        power = graphicsCard.power();
    }
}
