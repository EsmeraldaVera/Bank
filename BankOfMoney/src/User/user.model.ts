class User{
    static nextId: number = 0;
    public id: number;
    public account: number;
    public pin: number;
    public balance: number;
    

    constructor(account: number) {
        User.nextId++;
        this.id = User.nextId
        
    }
}

export { User }