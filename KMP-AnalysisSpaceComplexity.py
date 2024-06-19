"""
ASSIGNMENT 2 (Analysis Space Complexity for KMP Algorithm)

MEMBER 1: ANDYCLOS A/L BOON MEE (22300738)
MEMBER 2: MUHAMMAD EZZAT HAZIQ BIN ELHAN (22300604)
MEMBER 3: KAM WENG XUAN (22300683)
MEMBER 4: LOH WEI TING (22300549)
"""

import pandas as pd
import matplotlib.pyplot as plt

# manually input data based on the run experiment
data = [
    {"pattern_size": 10, "text_size": 1000, "total_space": 40},
    {"pattern_size": 20, "text_size": 1000, "total_space": 80},
    {"pattern_size": 30, "text_size": 1000, "total_space": 120},
    {"pattern_size": 40, "text_size": 1000, "total_space": 160},
    {"pattern_size": 50, "text_size": 1000, "total_space": 200},
]

# Convert the list of dictionaries to a DataFrame
df = pd.DataFrame(data)

# Plot the data
plt.figure(figsize=(10, 6))

# Create separate lines for each alphabet size
for alphabet_size in df['text_size'].unique():
    subset = df[df['text_size'] == alphabet_size]
    plt.plot(subset['pattern_size'], subset['total_space'], label=f'Text size: {alphabet_size}')

plt.xlabel('Pattern Size')
plt.ylabel('Total Space (bytes)')
plt.title('KMP Algorithm Space Complexity - O(m)')
plt.legend()
plt.grid(True)
plt.show()