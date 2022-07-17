import myIcon from '../../assets/img/notification-icon.svg';
import './style.css';

function BtnNotification() {
    return (
        <div className='dsmeta-red-btn'>
            <img src={myIcon} alt='Notificar' />
        </div>
    )
}

export default BtnNotification