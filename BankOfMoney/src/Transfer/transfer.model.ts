class Transfer {
    static nextId: number = 0;
    public id: number;
    public transfer_to: number;
    public transfer_from: number;
    public amount: number;
    constructor(transferTo: number) {
        Transfer.nextId++;
        this.id = Transfer.nextId
        this.transfer_to = this.transfer_to;
        this.transfer_from = this.transfer_from;
        this.amount = this.amount;
    }
}

export { Transfer }