public class Jaccard implements Similarity{
	public double score(WordMap a, WordMap b){
		int aSize = a.size();
		int bSize = b.size();

		double intersection = 0;
		double union = 0;
		String[] setElems; 
		//brute force way of union will have to change 
		//making sure every element is cycled through 
		if (bSize < aSize){
			setElems = a.keys();
			for (int i = 0; i < aSize; i++){
				if (b.contains(setElems[i])){
					intersection++;
				}
				union++;
				//b.update(setElems[i]);
			}
			//return (intersection/(b.keys()).length);
			return (intersection/union);
		}else{
			setElems = b.keys();
			for (int i = 0; i < bSize; i++){
				if (a.contains(setElems[i])){
					intersection++;
				}
				//a.update(setElems[i]);
				union ++;
			}
			//return(intersection/(a.keys()).length);
			return (intersection/union);
		}

	}

}