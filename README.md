<p>
  <img src="./src/assets/Template+ONE+Aluno+Back+END_PT+v3.png" alt="ONE BANNER">
</p>

# Currency Exchange System

This project implements a currency exchange rate query system with real-time data and value conversion calculation. The system provides a simple console interaction and two query modes:
- Quick mode, for users needing essential information only.
- Complete mode, for users wanting comprehensive information beyond the basics.

## Key Features

- **Beginner Mode:** Allows users to choose two currencies from a set of 7 predefined currencies, calculate the exchange rate between them, and perform currency conversions if needed.
- **Expert Mode:** Offers access to 162 different exchange rates, providing extensive currency information and conversion calculations.
- **Integration with External API:** Uses a currency exchange rate API to fetch updated data in real-time.
- **Graphical Data Display:** Simple yet human-friendly interface, ensuring good user experience.

## Main Components

- **Main:** Controls the main program flow, allowing users to choose between Beginner and Expert modes.
- **MerchantsWay:** Manages dynamic requests and full availability of data.
- **BeginnersWay:** Handles restricted requests with a predefined set of options.

## Technologies Used

- **Java:** Programming language used for business logic and user interaction.
- **HTTP Client:** Used to make calls to the currency exchange rate API and fetch updated data.
- **Gson:** JSON serialization/deserialization library used to parse API data.

## How to Use

1. **Clone the Repository:** `git clone https://github.com/your-username/repository-name.git`
2. **Compile the Code:** `javac Main.java`
3. **Run the Program:** `java Main`
4. **Follow Instructions in the Text Interface:** Choose the mode (Beginner or Expert) and follow instructions to query and calculate exchange rates.

## Contributions

Contributions are welcome! Feel free to open a pull request with improvements or bug fixes.
