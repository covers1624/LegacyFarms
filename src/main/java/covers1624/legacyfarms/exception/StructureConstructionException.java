package covers1624.legacyfarms.exception;

public class StructureConstructionException extends RuntimeException {
	private static final long serialVersionUID = -4039454931563371625L;

	public StructureConstructionException() {
	}

	public StructureConstructionException(String reason) {
		super(reason);
	}

}
