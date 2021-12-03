
import { User } from "./user.model";


const url = "http://localhost:8080/customers/";

class UserService {

    getUser(account: number) {
        // n/w call
        return fetch(url, { method: 'GET' })
            .then(response => response.json());

    }

}

export { UserService }  