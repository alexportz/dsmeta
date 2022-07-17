import logoImg from '../../assets/img/logo.svg';
import './style.css';

function Header() {
    return (
        <>
            <header>
                <div className="dsmeta-logo-container">
                    <img src={logoImg} alt="DSMeta Logo" />
                    <h1>DSMeta</h1>
                    <p>
                        Replicado por AlexPortz / Via Devsuperior
                        <a href="https://www.instagram.com/devsuperior.ig">@devsuperior.ig</a>
                    </p>
                </div>
            </header>
        </>
    )
}

export default Header