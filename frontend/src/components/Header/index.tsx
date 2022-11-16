import iconLogo from '../../assets/logo.svg'
import './styles.css'

function Header() {
    return (
        <header>
            <div className="emisales-logo-container">
                <img src={iconLogo} alt="page logo image" />
                    <h1>Emi's Sales</h1>
                    <p>Creator by <a href="https://github.com/EmileMoraes/" target="_blank">EmileMoraes</a></p>
            </div>
        </header>
    )
}

export default Header