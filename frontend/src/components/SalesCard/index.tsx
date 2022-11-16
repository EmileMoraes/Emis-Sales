import NotificationButton from '../NotificationButton';
import './styles.css';

import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { useState } from 'react';

function SalesCard() {

    const [minDate, setMinDate] = useState(new Date());
    const [maxDate, setMaxDate] = useState(new Date());

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
                        <tr>
                            <td className="show992">007</td>
                            <td className="show576">11/14/2022</td>
                            <td>Julia</td>
                            <td className="show992">15</td>
                            <td className="show992">2000</td>
                            <td>USD 33 0000</td>
                            <td>
                                <div className="emisales-red-botton-container">
                                    <NotificationButton />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td className="show992">001</td>
                            <td className="show576">10/14/2022</td>
                            <td>Citta</td>
                            <td className="show992">15</td>
                            <td className="show992">2000</td>
                            <td>USD 10000</td>
                            <td>
                                <div className="emisales-red-botton-container">
                                    <NotificationButton />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td className="show992">005</td>
                            <td className="show576">02/14/2022</td>
                            <td>Herman</td>
                            <td className="show992">15</td>
                            <td className="show992">2000</td>
                            <td>USD 22 0000</td>
                            <td>
                                <div className="emisales-red-botton-container">
                                    <NotificationButton />
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>

        </div>
    )
}

export default SalesCard;