# WebScraper

A modular Java 21 web scraping and extraction engine built with Maven, Jsoup, and JUnit 5. The application fetches web pages, parses raw HTML markup into structured domain models, and manages persistence through a decoupled architecture enforced by automated static analysis gates.

---

## Architecture Overview

The system enforces a clean separation of concerns across four primary components:

- **`Downloader`**: Handles HTTP connections and document fetching using Jsoup.
- **`Parser`**: Extracts CSS selector elements (e.g., titles, canonical URLs, text content) and parses raw markup into domain entities.
- **`ScrapedData`**: Data transfer entity storing extracted text, target URL, and capture timestamps.
- **`Repository`**: In-memory repository layer managing queries, item counts, and persistence.
- **`WebScrapingEngine`**: Main entry point coordinating download, transformation, and storage routines with SLF4J logging.

---

## Technical Stack

- **Language:** Java 21
- **HTML Parser:** Jsoup 1.22.2
- **Testing:** JUnit 5, OkHttp `MockWebServer` 4.12.0
- **Static Analysis & Linters:** Checkstyle 3.3.1, PMD 3.22.0, SpotBugs 4.8.6.2
- **Build Tool:** Apache Maven (Wrapper included)
- **CI/CD:** GitHub Actions

---

## Quality Assurance & Automated Gates

Every build is validated against strict automated quality controls configured to fail on rule violations (`failOnViolation=true`)

- **Checkstyle**: Enforces formatting standards, brace hygiene, and maximum method lengths via `checkstyle/checkstyle.xml`.
- **PMD**: Audits complexity, cyclomatic thresholds, and Java best practices using `pmd/pmd.xml`.
- **SpotBugs**: Runs static byte-code analysis to detect potential bugs and null-pointer hazards.
- **Unit Testing with MockWebServer**: Tests cover network responses, empty-state edge cases, and HTTP error handling (500 Server Errors) using local mock HTTP servers rather than hitting live endpoints.

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 21
- Git

### Installation

Clone the repository and navigate into the `webscraper` directory:

```bash
git clone [https://github.com/Zakariya-Mohamed/WebScraper.git](https://github.com/Zakariya-Mohamed/WebScraper.git)
cd WebScraper/webscraper
```
