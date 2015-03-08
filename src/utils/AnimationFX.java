package utils;

import javafx.animation.AnimationTimer;

public class AnimationFX {

	private static final double ANIMATION_STEP = 9;
	private static boolean isAnimatingSynchronous = false;
	private static ArrayList<AnimationList> animationsSynchronous = new ArrayList<>();
	private static AnimationList animationsAsynchronous = new AnimationList();
	private static ArrayList<Runnable> runnableAfterAllAnimations = new ArrayList<>();

	private AnimationFX() {

	}

	public static void startAnimation() {
		new AnimationTimerFX().start();
	}

	private static class AnimationTimerFX extends AnimationTimer {

		@Override
		public void handle(long time) {

			if (!animationsSynchronous.isEmpty())
				executeAnimationSynchronous();
			if (!animationsAsynchronous.isEmpty())
				executeAnimationAsynchronous();

		}

	}

	private static void executeAnimationSynchronous() {

		AnimationList animationList = animationsSynchronous.get(0);

		animationList.executeAnimations();

		if (!animationList.isEmpty())
			return;

		animationList.executeRunnableAfterAnimations();
		animationsSynchronous.remove(animationList);

		if (animationsSynchronous.isEmpty()) {

			if (!runnableAfterAllAnimations.isEmpty())
				executeRunnableAfterAllAnimations();

			isAnimatingSynchronous = false;
			return;
		}

		animationList = animationsSynchronous.get(0);
		animationList.calculateCredentials();
		animationList.executeRunnableBeforeAnimations();

	}

	private static void executeAnimationAsynchronous() {
		animationsAsynchronous.executeAnimations();
	}

	private static void executeRunnableAfterAllAnimations() {

		for (Runnable runnable : runnableAfterAllAnimations)
			runnable.run();

		runnableAfterAllAnimations.clear();

	}

	public enum AnimationSynchronization {

		SYNCHRONOUS, ASYNCHRONOUS

	}

	private static class AnimationList {

		private ArrayList<ImageviewAnimation> animation = new ArrayList<>();
		private ArrayList<Runnable> runnableBeforeExecution = new ArrayList<>();
		private ArrayList<Runnable> runnableAfterExecution = new ArrayList<>();

		public void add(ImageviewAnimation animation) {
			this.animation.add(animation);
		}

		public boolean isEmpty() {
			return this.animation.isEmpty();
		}

		public void executeAnimations() {

			ArrayList<ImageviewAnimation> animationTemp = new ArrayList<>(
					this.animation);

			for (ImageviewAnimation animationExecuting : animationTemp) {

				animationExecuting.executeAnimation();

				if (!animationExecuting.animationEnded())
					continue;

				this.animation.remove(animationExecuting);

			}

		}

		public void addRunnableBeforeExecution(Runnable runnable) {
			this.runnableBeforeExecution.add(runnable);
		}

		public void addRunnableAfterExecution(Runnable runnable) {
			this.runnableAfterExecution.add(runnable);
		}

		public void executeRunnableBeforeAnimations() {
			executeRunnable(this.runnableBeforeExecution);
		}

		public void executeRunnableAfterAnimations() {
			executeRunnable(this.runnableAfterExecution);
		}

		private void executeRunnable(ArrayList<Runnable> list) {

			for (Runnable runnable : list)
				runnable.run();

		}

		public void calculateCredentials() {

			for (ImageviewAnimation animationExecuting : this.animation)
				animationExecuting.calculateCedentials();

		}

	}

	private static class ImageviewAnimation {

		private ImageView imageView = null;
		private double currentX, currentY;
		private double endingX, endingY;
		private boolean animationEnded = false;
		private double stepX, stepY;

		public ImageviewAnimation(ImageView imageView, double endingX,
				double endingY) {

			this.imageView = imageView;
			this.endingX = endingX;
			this.endingY = endingY;

			calculateCedentials();

		}

		public void calculateCedentials() {

			this.currentX = this.imageView.getLayoutX();
			this.currentY = this.imageView.getLayoutY();

			double differenceX = Math.abs(this.endingX - this.currentX);
			double differenceY = Math.abs(this.endingY - this.currentY);

			if (differenceX > differenceY) {

				stepX = ANIMATION_STEP;
				stepY = differenceY * ANIMATION_STEP / differenceX;

			} else if (differenceY > differenceX) {

				stepX = differenceX * ANIMATION_STEP / differenceY;
				stepY = ANIMATION_STEP;

			} else if (differenceX == differenceY) {

				stepX = ANIMATION_STEP;
				stepY = ANIMATION_STEP;

			}

		}

		public void executeAnimation() {

			executeX();
			executeY();

			this.imageView.relocate(this.currentX, this.currentY);

			if (this.currentX != this.endingX)
				return;

			if (this.currentY != this.endingY)
				return;

			this.animationEnded = true;

		}

		private void executeX() {

			if (this.currentX == this.endingX)
				return;

			if (Math.abs(this.endingX - this.currentX) <= this.stepX) {
				this.currentX = this.endingX;
				return;
			}

			if (this.currentX < this.endingX)
				this.currentX += this.stepX;
			else if (this.currentX > this.endingX)
				this.currentX -= this.stepX;

		}

		private void executeY() {

			if (this.currentY == this.endingY)
				return;

			if (Math.abs(this.endingY - this.currentY) <= this.stepY) {
				this.currentY = this.endingY;
				return;
			}

			if (this.currentY < this.endingY)
				this.currentY += this.stepY;
			else if (this.currentY > this.endingY)
				this.currentY -= this.stepY;

		}

		public boolean animationEnded() {
			return this.animationEnded;
		}

	}

	public static void animate(ImageView imageView, double endingX,
			double endingY, AnimationSynchronization animationSynchronization) {

		switch (animationSynchronization) {

		case SYNCHRONOUS:

			if (!isAnimatingSynchronous)
				isAnimatingSynchronous = true;

			AnimationList animationList = null;

			if (!animationsSynchronous.isEmpty())
				animationList = animationsSynchronous.get(animationsSynchronous
						.size() - 1);
			else {

				animationList = new AnimationList();
				animationsSynchronous.add(animationList);

			}

			animationList.add(new ImageviewAnimation(imageView, endingX,
					endingY));

			break;

		case ASYNCHRONOUS:
			animationsAsynchronous.add(new ImageviewAnimation(imageView,
					endingX, endingY));
			break;

		}

	}

	public static void createNewAnimationQueueSynchronous() {
		animationsSynchronous.add(new AnimationList());
	}

	public static void addRunnableBeforeLastAnimation(Runnable runnable) {

		AnimationList animationList = animationsSynchronous
				.get(animationsSynchronous.size() - 1);

		animationList.addRunnableBeforeExecution(runnable);
	}

	public static void addRunnableAfterLastAnimation(Runnable runnable) {

		AnimationList animationList = animationsSynchronous
				.get(animationsSynchronous.size() - 1);

		animationList.addRunnableAfterExecution(runnable);
	}

	public static void addRunnableAfterAllAnimations(Runnable runnable) {
		runnableAfterAllAnimations.add(runnable);
	}

	public static boolean isAnimatingSynchronous() {
		return isAnimatingSynchronous;
	}

}
