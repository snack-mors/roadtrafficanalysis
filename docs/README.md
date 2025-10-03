# Road Traffic Analysis

This project analyzes roadway volume and speed data for a single corridor using multiple sensors and produces summary metrics (totals/averages) and simple quality checks.

## What this project demonstrates
- **OOP design:** clear separation between domain models (`RoadSection`, `RoadSpeed`, `RoadVolume`), I/O (`FileHandler`), and an application driver (`Project2`).
- **File parsing and validation:** accepts multiple CSV inputs; examples include both *clean* and *intentionally bad* inputs for testability.
- **Result reporting:** prints computed aggregates (e.g., volume totals/averages, speed averages).

## Layout
```
roadtrafficanalysis/
├─ src/
│  └─ main/java/
│     ├─ Project2.java
│     ├─ FileHandler.java
│     ├─ model/
│     │  ├─ RoadSection.java
│     │  ├─ RoadSpeed.java
│     │  └─ RoadVolume.java
├─ data/
│  ├─ Road_Section_Data_Example.csv
│  ├─ Speed_Data.csv
│  ├─ Speed_Data_Bad_Date.csv
│  ├─ Speed_Data_Bad_Num.csv
│  ├─ Volume_Data.csv
│  ├─ Volume_Data_Bad_Date.csv
│  └─ Volume_Data_Bad_Num.csv
└─ docs/
   ├─ flowchart.png
   └─ readme.md
```

## Input formats
Each CSV includes a `Date` and `Time` column. Sensor columns:
- **Speed:** `Speed_Sensor_2282`, `Speed_Sensor_2293` (mph)
- **Volume:** `Volume_Sensor_2003`, `Volume_Sensor_2004`, `Volume_Sensor_2005`, `Volume_Sensor_2006` (veh/hour)

⚠️ Date formats vary intentionally to test validation (e.g., `2015-02-05` vs `02/07/15`).

## Included datasets
| File | Purpose | Notes |
|---|---|---|
| `Road_Section_Data_Example.csv` | Combined sample with computed totals/averages | Good “golden path” example |
| `Speed_Data.csv` | Clean speed dataset | Dates in ISO-like format |
| `Speed_Data_Bad_Date.csv` | Bad speed dates | Should trigger date parsing validation |
| `Speed_Data_Bad_Num.csv` | Bad speed numbers | Non-numeric values in numeric column(s) |
| `Volume_Data.csv` | Clean volume dataset | Dates in `MM/DD/YY` |
| `Volume_Data_Bad_Date.csv` | Bad volume dates | Non-parseable dates |
| `Volume_Data_Bad_Num.csv` | Bad volume numbers | Strings in numeric fields |

## How to run
> Java 11+ recommended.

**Option A — Compile and run with `javac/java`:**
```bash
# from repo root
javac -d out src/main/java/*.java src/main/java/model/*.java
java -cp out Project2
```

When prompted, provide paths to the input CSV files, for example:
```
data/Volume_Data.csv
data/Speed_Data.csv
```

## Expected behavior
- **Valid inputs**: prints per-row/aggregate metrics (e.g., `Volume_Total`, `Volume_Avg`, `Speed_Avg`) or a summary at the end.
- **Bad date inputs**: the program should fail fast with a clear message (e.g., `Could not parse Date '02/31/15' at row 42`).
- **Bad numeric inputs**: the program should report the problematic field and row (`Non-numeric speed 'NA' at row 17, column Speed_Sensor_2282`).

## Potential improvements I could do:
1. **Add `RoadAnalyzer`** to concentrate domain logic (averages/aggregation/alerts).
2. **Make models immutable** (`final` fields, validate in constructor).
3. **Centralize constants & units** (mph vs vph) in one place.
4. **Add 2–3 tiny JUnit tests** (parse OK, bad date, bad number).
5. **Replace debug prints** with consistent output formatting.

## What I learned
- Designed basic data model for traffic sensors and sections.
- Implemented CSV parsing with validation and useful error messages.
- Computed aggregates and demonstrated handling of edge cases.
- Documented approach with a flowchart to communicate design.
