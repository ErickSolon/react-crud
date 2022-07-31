import React from "react";

const Header = ({ title }) => {
    return (
        <header>
            <h1>{title ? title : "digite o título desejado!"}</h1>
        </header>
    );
}

export default Header;