import './index.scss'
import { Transfer } from './transfer.model'
import { TransferService } from './transfer.service'


const transferService = new TransferService()
// transferService.addTransfer("transfer-1")
// transferService.addTransfer("transfer-2")


//-----------------------------------------------------
// DOM Fields
//-----------------------------------------------------
const newTransferField = document.getElementById("new-transfer")
const transferListEle = document.getElementById('transfer-list')
//-----------------------------------------------------
// Event Handlers
//-----------------------------------------------------

newTransferField.addEventListener('keyup', (e: KeyboardEvent) => {
    // e.preventDefault();
    const key = e.key;
    const target = (<HTMLInputElement>e.target)
    let transferTo = target.value
   
    const amount = target.value;
    if (transferTo && amount === "") return
    if (key !== 'Enter') return
    // transferService.addTransfer(transferTo, amount)
    //     .then(response => {
    //         target.value = ""
    //         renderTransfer()
    //     })

})

// window.addEventListener('click', e => {
//     console.log(e);
// })

// transferListEle.addEventListener('click', e => {
//     e.stopPropagation();
//     const dataset = (<HTMLInputElement>e.target).dataset;
//     const action = dataset['action']
//     if (action === 'complete') {
//         const id = dataset['id'];
//         transferService.completeTransfer(Number.parseInt(id))
//     }

// })


//-------------------------------------------------------
// Render Transfers
//-------------------------------------------------------
async function renderTransfer(filter = 'ALL') {
    const transfer = await transferService.getTransfer(filter)
    const transferListElements = transfer.map((transfer: Transfer) => {
        return `
            <li class="list-group-item d-flex justify-content-between >
                <span>${transfer.transfer_to}</span>
                <button data-action="delete" data-id=${transfer.id} class="btn btn-sm btn-danger">delete</button>
            </li>
        `
    });
    transferListEle.innerHTML = transferListElements.join("")
}
renderTransfer();