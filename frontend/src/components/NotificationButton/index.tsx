import axios from 'axios';
import { toast } from 'react-toastify';
import icon from '../../assets/Vector.svg'
import { BASE_URL } from '../../utils/request';
import './styles.css'

type Props = {
    saleId: number;
}

function handleClik(id: number) {
    axios(`${BASE_URL}/v0/api/sales/${id}/notification`)
    .then(response => {
        toast.info("SMS send successfully!")
    })
}

function NotificationButton({saleId} : Props) {
    return (
        <div className="emisales-red-botton" onClick={() => handleClik(saleId)}>
            <img src={icon} alt="notification" />
        </div>
    )
}

export default NotificationButton