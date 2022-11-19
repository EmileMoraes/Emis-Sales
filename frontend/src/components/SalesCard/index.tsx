import NotificationButton from '../NotificationButton';
import './styles.css';

import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { useEffect, useState } from 'react';
import axios from 'axios';
import { BASE_URL } from '../../utils/request';
import { Sale } from '../../models/sale';

function SalesCard() {


    const [minDate, setMinDate] = useState(new Date());
    const [maxDate, setMaxDate] = useState(new Date());

    const [sales, setSales] = useState<Sale[]>([]);

    useEffect(() => {

        const dmin = minDate.toISOString().slice(0, 10);
        const dmax = maxDate.toISOString().slice(0, 10);

        axios.get(`${BASE_URL}/v0/api/sales/date?minDate=${dmin}&maxDate=${dmax}`)
            .then(response => {
                setSales(response.data.content);
            });
    }, [minDate, maxDate]);

    return (
        <div className="emisales-card">
            <h2 className="emisales-sales-title">Sales</h2>

            <div>
                <div className="emisales-form-control-container">
                    <DatePicker selected={minDate}
                        onChange={(date: Date) => setMinDate(date)}
                        className="emisales-form-control"
                        dateFormat="MM/dd/yyyy"
                    />
                </div>
                <div className="emisales-form-control-container">
                    <DatePicker selected={maxDate}
                        onChange={(date: Date) => setMaxDate(date)}
                        className="emisales-form-control"
                        dateFormat="MM/dd/yyyy"
                    />
                </div>
            </div>

            <div>
                <table className="emisales-sales-table">
                    <thead>
                        <tr>
                            <th className="show992">ID</th>
                            <th className="show576">Date</th>
                            <th>Saller</th>
                            <th className="show992">Visits</th>
                            <th className="show992">Sales</th>
                            <th>Total</th>
                            <th>Notification</th>
                        </tr>

                    </thead>

                    <tbody>
                        {
                            sales.map(sale => {
                                return (
                                    <tr key={sale.id}>
                                        <td className="show992">{sale.id}</td>
                                        <td className="show576">{new Date(sale.date).toLocaleDateString()}</td>
                                        <td>{sale.sellerName}</td>
                                        <td className="show992">{sale.visited}</td>
                                        <td className="show992">{sale.deals}</td>
                                        <td>{sale.amount.toFixed(2)}</td>
                                        <td>
                                            <div className="emisales-red-botton-container">
                                                <NotificationButton saleId={sale.id}/>
                                            </div>
                                        </td>
                                    </tr>
                                )
                            })
                        }
                    </tbody>
                </table>
            </div>

        </div>
    )
}

export default SalesCard;