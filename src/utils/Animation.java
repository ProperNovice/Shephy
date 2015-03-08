package utils;

import javafx.animation.AnimationTimer;

public class Animation {

	private static final double ANIMATION_STEP = 9;
	private static ArrayList<ImageViewAnimation> animationsSynchronous = new ArrayList<>();
	private static ArrayList<ImageViewAnimation> animationsAsynchronous = new ArrayList<>();

	private Animation() {

	}

	public enum AnimationSynchronization {

		SYNCHRONOUS, ASYNCHRONOUS

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

		executeAnimationList(animationsSynchronous);

		if (!animationsSynchronous.isEmpty())
			return;

		Lock.unlock();

	}

	private static void executeAnimationAsynchronous() {

		executeAnimationList(animationsAsynchronous);

	}

	private static void executeAnimationList(
			ArrayList<ImageViewAnimation> animationsList) {

		ArrayList<ImageViewAnimation> animationsListTemp = new ArrayList<>(
				animationsList);

		for (ImageViewAnimation imageViewAnimation : animationsListTemp) {

			imageViewAnimation.executeAnimation();

			if (!imageViewAnimation.animationEnded())
				continue;

			animationsList.remove(imageViewAnimation);

		}

	}

	private static class ImageViewAnimation {

		private ImageView imageView = null;
		private double currentX, currentY;
		private double endingX, endingY;
		private boolean animationEnded = false;
		private double stepX, stepY;

		public ImageViewAnimation(ImageView imageView, double endingX,
				double endingY) {

			this.imageView = imageView;
			this.endingX = endingX;
			this.endingY = endingY;

			calculateCedentials();

		}

		private void calculateCedentials() {

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

		PlatformFX.runLater(() -> {

			ArrayList<ImageViewAnimation> listToAdd = null;

			switch (animationSynchronization) {

			case SYNCHRONOUS:
				listToAdd = animationsSynchronous;
				break;

			case ASYNCHRONOUS:
				listToAdd = animationsAsynchronous;
				break;

			}

			listToAdd.add(new ImageViewAnimation(imageView, endingX, endingY));

		});

	}

}
