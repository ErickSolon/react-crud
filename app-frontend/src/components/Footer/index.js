import React from "react";

const Footer = ({ footer }) => {
    return (
        <footer>
            <h3>{footer?footer:"Digite o rodapé da página!"}</h3>
        </footer>
    );
}

export default Footer;