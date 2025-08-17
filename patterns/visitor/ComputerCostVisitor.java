package org.example.patterns.visitor;

public class ComputerCostVisitor implements ComputerVisitor {
    private int totalCost = 0;

    public int getTotalCost() {
        return totalCost;
    }

    @Override
    public void visitMotherboard(Motherboard motherboard) {
        totalCost += motherboard.cost();
    }

    @Override
    public void visitCPU(CPU cpu) {
        totalCost += cpu.cost();
    }

    @Override
    public void visitRAM(RAM ram) {
        totalCost += ram.cost();
    }

    @Override
    public void visitDisk(Disk disk) {
        totalCost += disk.cost();
    }

    @Override
    public void visitGraphicsCard(GraphicsCard graphicsCard) {
        totalCost += graphicsCard.cost();
    }
}
