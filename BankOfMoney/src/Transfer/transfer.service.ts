import { Transfer_FILTERS } from "./transfer.filter";
import { Transfer } from "./transfer.model";


const url = "http://localhost:8080/customer/vera/transfer";

class TransferService {

    transfer: Array<Transfer> = []

    addTransfer(transfer_to: number, amount: number) {
        
        return fetch(url, {
            method: 'POST',
            body: JSON.stringify({ transfer_to, amount }),
            headers: {
                'Content-Type': 'application/json' // Media Type
            }
        })

    }


    getTransfer(filter: any) {
        // n/w call
        return fetch(url, { method: 'GET' })
            .then(response => response.json());

    }

}

export { TransferService }