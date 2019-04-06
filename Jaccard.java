public class Jaccard implements Similarity{
	public double score(WordMap a, WordMap b){
		int aSize = a.size();
		int bSize = b.size();

		double intersection = 0;
		double union = 0;
		String[] setElems; 
		// brute force way of union will have to change 
		// making sure every element is cycled through 
		if (bSize < aSize){
			setElems = a.keys();
			for (int i = 0; i < aSize; i++){
				if (a.get(setElems[i]) < 2){
					if (b.contains(setElems[i])){
						intersection++;
					}
					union++;
					a.update(setElems[i]);
				}
			
			}
			// System.out.println("Intersection is " + intersection);
			// System.out.println("Union is " + union);
			return (intersection/union);
		}else{
			setElems = b.keys();
			for (int i = 0; i < bSize; i++){
				if(b.get(setElems[i])< 2){
					if (a.contains(setElems[i])){
						intersection++;
					}
					union ++;
					b.update(setElems[i]);
				}
	
			}
			// System.out.println("Intersection is " + intersection);
			// System.out.println("Union is " + union);
			return (intersection/union);
		}
		// WordMap intersection = new LinkedWordMap();
		// WordMap union = new LinkedWordMap();
		// if (bSize < aSize){
		// 	setElems = a.keys();
		// 	for (int i = 0; i < aSize; i++){
		// 		if(!intersection.contains(setElems[i])){
		// 			if (b.contains(setElems[i])){
		// 				intersection.update(setElems[i]);
		// 				union.update(setElems[i]);
		// 			}else{

		// 			}
		// 		}
		
		// 	}
		// }else{

		// }
	}

}