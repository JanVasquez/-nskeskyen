function render() {
    const container = document.getElementById("wishlist");
    container.innerHTML = "";

    wishes.forEach((w, i) => {
        const div = document.createElement("div");
        div.className = `card ${w.priority} ${w.reserved ? "reserved" : ""}`;

        div.innerHTML = `
            <h3>${w.title}</h3>
            <p>💰 ${w.price} kr</p>
            <a href="${w.link}" target="_blank">Se produkt</a>

            <br><br>

            <button onclick="toggleReserved(${i})">
                ${w.reserved ? "Fjern reservation" : "Reserver"}
            </button>

            <button onclick="deleteWish(${i})">Slet</button>
        `;

        container.appendChild(div);
    });
}

window.onload = render;