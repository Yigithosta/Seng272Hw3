# ISO 15939 Measurement Process Simulator  
## Requirements and Design Document

---

## 1. Introduction

This project is a Java Swing desktop application that simulates the ISO/IEC 15939 software measurement process. The application guides users through a structured workflow to define software quality metrics, collect measurement data, and perform analysis.

---

## 2. System Overview

The application follows a sequential workflow:

1. Profile → User enters information  
2. Define → Select quality type, mode, scenario  
3. Plan → Display metrics  
4. Collect → Calculate scores  
5. Analyse → Evaluate results  

---

## 3. Functional Requirements

### FR1 – Profile Input
- Username
- School
- Session name
- All fields must be filled

### FR2 – Quality Definition
- Product / Process
- Health / Education
- Scenario selection

### FR3 – Plan
- Display metrics (read-only)

### FR4 – Collect
Score formulas:score = 1 + (value - min) / (max - min) * 4


score = 5 - (value - min) / (max - min) * 4

### FR5 – Analyse
- Weighted average
- Lowest dimension
- Gap (5 - score)

---

## 4. Non-Functional Requirements

- Java SE 17
- Swing GUI
- No external libraries
- MVC architecture

---

## 5. Architecture (MVC)

**Model:** Metric, Dimension, Scenario  
**View:** GUI panels  
**Controller:** Event handling  

---

## 6. Class Design

- Metric → score calculation  
- Dimension → weighted average  
- Scenario → dataset  
- MainFrame → navigation  

---

## 7. Use Case

User:
1. enters data  
2. selects scenario  
3. views metrics  
4. system calculates  
5. system analyzes  

---

## 8. GUI Design

- CardLayout wizard
- 5 panels
- JTable + ProgressBar

---

## 9. Data Design

- Hardcoded scenarios
- Multiple dimensions and metrics

---

## 10. Conclusion

This system simulates ISO 15939 measurement process using structured evaluation and analysis.
