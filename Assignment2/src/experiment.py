import subprocess
import random
import numpy as np
import math
import matplotlib.pyplot as plt
import matplotlib.scale as scale
class Experiment():
    SAMPLE = "../data/experiment.txt"
    def __init__(self, size):
        self.size = size
        Experiment.create_file(size)

    @staticmethod
    def create_file(size):
        with open("../data/GenericsKB.txt", "r") as f:
            lines = f.readlines()
        
        sampled_lines = random.sample(lines, size)
        
        with open(Experiment.SAMPLE, "w") as f:
            f.writelines(sampled_lines)   
    
    def run(self):
        subprocess.run(["make", "run", f"SOURCE={Experiment.SAMPLE}", "QUERY=../data/GenericsKB-queries.txt"])

# class Line():
#     def __init__(self, data):
        
        

def readData():
    with open("../output/result.csv", "r") as f:
        lines = f.readlines()
    data = []
    for line in lines:
        data.append(line.split(","))
    
    return data

def graph():
    x = np.arange(0.0, 50000.1, 5000)
    data = readData()
    y1 = [datum[2] for datum in data]
    y2 = [datum[3] for datum in data]
    plt.subplot(121)
    plt.plot(x, y1, "r-")
    plt.plot(x, np.log(x), "g-")
    
    plt.subplot(122)
    plt.plot(x, y2, "b-")
    plt.plot(x, np.log(x), "g-")
    plt.show()

def main():
    with open("../output/result.csv", "w"):
        pass
    i = 1
    experiments = []
    while (i <= 50000):
        experiment = Experiment(round(i))
        experiment.run()
        experiments.append(experiment)
        i *=  3
    data = readData()
    fig, (ax1, ax2) = plt.subplots(ncols=2, sharex=True, sharey = True)
    
    x = np.array([datum[0] for datum in data])
    y_insert = [datum[2] for datum in data]
    y_search = [datum[3] for datum in data]
    ax1.scatter(x, y_insert, color="r", label="Empirical")
    ax1.plot(x, np.log(x.astype(float)), label="Average/Worst")
    ax1.axhline(y=1.1, color="g", linewidth=2, label="Best")
    ax1.set_ylim(1, 40)
    ax2.scatter(x, y_search, color="k", label="Empirical")
    ax2.plot(x, np.log(x.astype(float)))
    ax2.plot(x, np.log(x.astype(float)), label="Average/Worst")
    ax2.axhline(y=1.1, color="g", linewidth=2, label="Best")
    for ax in plt.gcf().get_axes():
        ax.legend()
        ax.set_ylabel("Number of Operations")
        ax.set_yscale("log")
        ax.set_xlabel("Size of Datasets")
        ax.tick_params(axis='x', rotation=90) 
    plt.tight_layout()
    plt.title("Time Complexity Analysis")
    plt.show()
    
    
    
    

if __name__ == "__main__":
    main()
    # graph()